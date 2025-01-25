package urlshortner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class URLShortner {
    /*storage to store long url and user info*/
    private final Map<String, String> urlMap = new HashMap<>();
    private final Map<String, String> userMap = new HashMap<>();

    public String shortenUrl(String longUrl, String userId) {
        String token = generateTokenUsingHashAlgo(longUrl);
        urlMap.put(token, longUrl);
        userMap.put(token, userId);
        return "https://mmt.yt/" + token;
    }

    public String accessUrl(String shortUrl, String userId) {
        String url = shortUrl.replace( "https://mmt.yt/", "");
        if (urlMap.containsKey(url) && Objects.equals(userMap.get(url), userId)) {
            return "Access Granted";
        } else {
            return "Unauthorized Access";
        }
    }

    private String generateTokenUsingHashAlgo(String longUrl) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(longUrl.getBytes());
            return Base64.getUrlEncoder().encodeToString(hash).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String longUrl = "https://makemytrip.com/booking?booking_id=1234&user_id=1230";
        String userId = "1230";
        URLShortner urlShortner = new URLShortner();
        String shorUrl = urlShortner.shortenUrl(longUrl, userId);
        System.out.println(shorUrl);
        String access = urlShortner.accessUrl(shorUrl, "1231");
        System.out.println(access);
    }
}
