[![Build Status](https://travis-ci.com/magnetcoop/biscuit.svg?branch=master)](https://travis-ci.com/magnetcoop/biscuit)

# Biscuit

A Clojure library for calculating message digest(ive)s. The digest algorithms implemented in biscuit are all variations of [CRCs](http://en.wikipedia.org/wiki/Cyclic_redundancy_check) and are designed to verify the integrity of messages sent over noisy channels.

## Installation

Add the following dependency to your `project.clj` file:

```clojure
[magnet/biscuit "1.1.0"]
```

## Usage

Digests can be calculated on raw byte arrays or on strings. When calculated on strings, they need to be converted to raw bytes arrays. In that case, you can specify the character encoding of the string. If you don't specify it, UTF-8 encoding is used by default.

```clojure
user> (require '[biscuit.core :as digest])
nil
user> (digest/crc8 (byte-array [195, 161, 195, 169, 195, 173, 195, 179, 195, 186]))
166
user> (digest/crc8 (byte-array [225, 0, 233, 0, 237, 0. 243, 0, 250, 0]))
203
user> (digest/crc8 "hobnob")
17
user> (digest/crc8 "áéíóú")
166
user> (digest/crc8 "áéíóú" "UTF-8")
166
user> (digest/crc8 "áéíóú" "ISO-8859-1")
7
user> (digest/crc8 "áéíóú" "UTF-16LE")
203
user> 
```

The following algorithms are supported:

* CRC1
* CRC5
* CRC8
* CRC8 1-wire
* CRC16
* CRC16 CCITT
* CRC16 DNP
* CRC16 Modbus
* CRC16 USB
* CRC16 XModem
* CTC16 ZModem
* CRC24
* CRC32
* CRC32c
* CRC32 MPEG
* CRC64

**Performance notice:** CRC64 implementation uses `BigInteger`s, as native Clojure `Long`s and `BigInt`s are not big enough to hold the required values. This means the CRC64 implementation is *extremely* slow compared to the rest of the CRCs implemented by the library.

## Credit

This library is strongly influenced by the [digest-crc](https://github.com/postmodern/digest-crc) ruby gem.

## License

Copyright © 2012 Henry Garner
Copyright © 2019 Magnet S. Coop.

Distributed under the Eclipse Public License, the same as Clojure.
