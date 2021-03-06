// Source: https://github.com/ShcherbinaMariia/Cryptography/tree/master/SHA256

#pragma once
#include <string>
#include <limits.h>
#include<vector>
#include<cstring>

using byte = unsigned char;

class SHA256{
private:
	const static unsigned int k[];
	const static byte kEndMessageByte = byte(128);
	const static byte kZeroByte = byte(0);
	const static unsigned int kBlockSize = 512;
	const static unsigned int kNumRounds = 64;

	unsigned int h[8];

	void init();
	byte* preprocess(byte* message, unsigned int message_bytes);
	void processBlock(byte *message, int start, unsigned int *w);
public:
	std::string hash(std::string message);
};
