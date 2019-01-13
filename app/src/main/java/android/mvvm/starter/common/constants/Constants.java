package android.mvvm.starter.common.constants;
public class Constants {
    public static final String LOG_TAG = "APP_TAG";
    public static class Cryptography {
        public static final String KEY_STORE = "AndroidKeyStore";
        public static final String AES_KEY = "aes_key";
        public static final String HMAC_KEY = "hmac_key";
        public static final String PKI = "pki";
        public static class Aes {
            public static final String AES_CBC_NO_PADDING = "AES/GCM/NoPadding";
            public static final String AES_CBC_PKCS7_PADDING = "AES/CBC/PKCS7Padding";
            public static final String AES_CTR_NO_PADDING = "AES/CTR/NoPadding";
            public static final String AES_ECB_NO_PADDING = "AES/ECB/NoPadding";
            public static final String AES_ECB_PKCS7_PADDING = "AES/ECB/PKCS7Padding";
            public static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
        }
        public static class Hash {
            public static final String MD5 = "MD5";
            public static final String SHA256 = "SHA-256";
            public static final String SHA512 = "SHA-512";
            public static final String HMAC_SHA_256 = "HmacSHA256";
            public static final String HMAC_SHA_512 = "HmacSHA512";
        }
    }
}
