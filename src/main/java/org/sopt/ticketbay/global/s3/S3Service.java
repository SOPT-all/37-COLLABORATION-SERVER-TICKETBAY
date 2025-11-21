package org.sopt.ticketbay.global.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String generatePresignedUrl(String key) {
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // 1시간
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket, key)
            .withMethod(HttpMethod.GET)
            .withExpiration(expiration);

        return amazonS3.generatePresignedUrl(request).toString();
    }

}
