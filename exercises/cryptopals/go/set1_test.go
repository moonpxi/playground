package main

import (
	"testing"
)

func TestSet1Challenge1(t *testing.T) {
	expectedBase64String := "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
	actualBase64String := hexToBase64("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")

	assertEquals(t, expectedBase64String, actualBase64String)
}

func TestSet1Challenge2(t *testing.T) {
	expectedXor := "746865206b696420646f6e277420706c6179"
	actualXor := bytesToHex(
		xorBytes(
			hexToBytes("1c0111001f010100061a024b53535009181c"),
			hexToBytes("686974207468652062756c6c277320657965")))

	assertEquals(t, expectedXor, actualXor)
}

func TestSet1Challenge3(t *testing.T) {
	hexEncodedString := "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
	result := crackSingleByteXorCipher(hexEncodedString)

	assertEquals(t, "Cooking MC's like a pound of bacon", result.message)
	assertEquals(t, byte(88), result.key)
}

func TestSet1Challenge4(t *testing.T) {
	lines := readLines("files/4.txt")

	jobs := make(chan string, len(lines))
	results := make(chan crackResult, len(lines))

	for _, line := range lines {
		jobs <- line
	}
	close(jobs)

	for w := 0; w <= 5; w++ {
		go func() {
			for line := range jobs {
				results <- crackSingleByteXorCipher(line)
			}
		}()
	}

	var bestResult crackResult

	for i := 0; i < len(lines); i++ {
		result := <-results
		if result.score > bestResult.score {
			bestResult = result
		}
	}

	assertEquals(t, "Now that the party is jumping\n", bestResult.message)
	assertEquals(t, byte(53), bestResult.key)
}

func TestSet1Challenge5(t *testing.T) {
	phrase := "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal"
	key := "ICE"

	expected := "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"

	actual := bytesToHex(xorBytes([]byte(phrase), []byte(key)))

	assertEquals(t, expected, actual)
}