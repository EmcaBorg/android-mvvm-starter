package android.mvvm.starter.common.di.modules;

import android.mvvm.starter.common.constants.Constants;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class KeystoreModule {

    @Provides
    KeyStore provideKeyStore() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(Constants.Cryptography.KEY_STORE);
            keyStore.load(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyStore;
    }

    @Provides
    @Singleton
    @Named("AESKey")
    SecretKey provideAesKey(KeyStore keyStore) {
        KeyGenerator keyGenerator = null;
        try {
            Key key = keyStore.getKey(Constants.Cryptography.AES_KEY, null);
            if (key != null) {
                return (SecretKey) key;
            }
            keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, Constants.Cryptography.KEY_STORE);
            final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(Constants.Cryptography.AES_KEY,
                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .build();
            keyGenerator.init(keyGenParameterSpec);
        } catch (UnrecoverableEntryException e) {

        } catch (KeyStoreException e) {

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }

    @Provides
    @Singleton
    @Named("HMACKey")
    SecretKey provideHmacKey(KeyStore keyStore) {
        KeyGenerator keyGenerator = null;
        try {
            Key key = keyStore.getKey(Constants.Cryptography.HMAC_KEY, null);
            if (key != null) {
                return (SecretKey) key;
            }
            keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_HMAC_SHA256, Constants.Cryptography.KEY_STORE);
            final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(Constants.Cryptography.HMAC_KEY,
                    KeyProperties.PURPOSE_SIGN)
                    .build();
            keyGenerator.init(keyGenParameterSpec);
        } catch (UnrecoverableEntryException e) {

        } catch (KeyStoreException e) {

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }
}
