package com.thomashayashi.Encryption;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/encryption/problem
 */
class EncryptionTest {
 @Test
 void checkEncryption() {
  assertEquals("hae and via ecy", encryption("have a nice day"));
  assertEquals("fto ehg ee dd", encryption("feed the dog"));
  assertEquals("clu hlt io", encryption("chill out"));
 }

 private String encryption(String s) {
  s = s.replace(" ","");

  int wordSize = s.length();
  int columns = (int)Math.ceil(Math.sqrt(wordSize));

  List<String> brokenWords = new ArrayList<>();
  for (int start = 0; start < wordSize; start += columns)
   brokenWords.add(s.substring(start, Math.min(wordSize, start + columns)));

  List<String> encryptedWords = new ArrayList<>();
  for (int i = 0; i < columns; i++) {
   StringBuilder encrypted = new StringBuilder();
   for (String brokenWord : brokenWords) {
    if(i < brokenWord.length())
     encrypted.append(brokenWord.charAt(i));
   }

   encryptedWords.add(encrypted.toString());
  }

  return String.join(" ", encryptedWords);
 }
}
