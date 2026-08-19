package van.project.wechat.wechatPublic.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Slf4j
public class SignatureUtil {

    public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        String[] content = {token, timestamp, nonce};
        Arrays.sort(content);
        StringBuilder sb = new StringBuilder();
        for (String s : content) {
            sb.append(s);
        }

        byte[] digest = md.digest(sb.toString().getBytes());
        String anObject = bytesToHexString(digest);
        return signature.equals(anObject);
    }
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}
