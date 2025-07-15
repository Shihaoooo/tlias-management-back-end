package com.itheima.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
@Component
public class AliyunOSSOperator {
//    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//
//    // 填写Bucket名称，例如examplebucket。
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;
//
//    // 填写Bucket所在地域。以华东1（杭州）为例，Region填写为cn-hangzhou。
//    @Value("${aliyun.oss.region}")
//    private String region;

    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;

    public String upload(String originalFileName, InputStream file) throws Exception {

        String endpoint = aliyunOSSProperties.getEndpoint();

        String region = aliyunOSSProperties.getRegion();

        String bucketName = aliyunOSSProperties.getBucketName();

        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 创建OSSClient实例。
        // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();

        // 生成统一文件名
        String fileName = fileNameGenerator(originalFileName);

        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return endpoint.split("//")[0] + bucketName + "." +endpoint.split("//")[1] + "/" + fileName;
    }

    public String fileNameGenerator(String originalFileName) {
        // 生成标识UUID
        String uuid = UUID.randomUUID().toString();

        // 生成当前日期的字符串
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        // 获取文件名的后缀
        String end = originalFileName.substring(originalFileName.lastIndexOf("."));

        // 拼接并返回
        return date + "/" +uuid + end ;

    }
}
