package com.zac.security.des;

/**
 * DES  password
 * 
 */
 class DES {
  private int[] subkey1 = new int[16];
  private int[] subkey2 = new int[16];

  private static final boolean[] ks = { // key shift
      false, false, true, true, true, true, true, true,
      false, true, true, true, true, true, true, false
  };
  private static final int kp[][] = {
      { // key permutation
      0x00000000, 0x00040000, 0x01000000, 0x01040000,
      0x00000400, 0x00040400, 0x01000400, 0x01040400,
      0x00200000, 0x00240000, 0x01200000, 0x01240000,
      0x00200400, 0x00240400, 0x01200400, 0x01240400,
      0x00000001, 0x00040001, 0x01000001, 0x01040001,
      0x00000401, 0x00040401, 0x01000401, 0x01040401,
      0x00200001, 0x00240001, 0x01200001, 0x01240001,
      0x00200401, 0x00240401, 0x01200401, 0x01240401,
      0x02000000, 0x02040000, 0x03000000, 0x03040000,
      0x02000400, 0x02040400, 0x03000400, 0x03040400,
      0x02200000, 0x02240000, 0x03200000, 0x03240000,
      0x02200400, 0x02240400, 0x03200400, 0x03240400,
      0x02000001, 0x02040001, 0x03000001, 0x03040001,
      0x02000401, 0x02040401, 0x03000401, 0x03040401,
      0x02200001, 0x02240001, 0x03200001, 0x03240001,
      0x02200401, 0x02240401, 0x03200401, 0x03240401
  }
      , {
      0x00000000, 0x00000002, 0x00000800, 0x00000802,
      0x08000000, 0x08000002, 0x08000800, 0x08000802,
      0x00010000, 0x00010002, 0x00010800, 0x00010802,
      0x08010000, 0x08010002, 0x08010800, 0x08010802,
      0x00000100, 0x00000102, 0x00000900, 0x00000902,
      0x08000100, 0x08000102, 0x08000900, 0x08000902,
      0x00010100, 0x00010102, 0x00010900, 0x00010902,
      0x08010100, 0x08010102, 0x08010900, 0x08010902,
      0x00000010, 0x00000012, 0x00000810, 0x00000812,
      0x08000010, 0x08000012, 0x08000810, 0x08000812,
      0x00010010, 0x00010012, 0x00010810, 0x00010812,
      0x08010010, 0x08010012, 0x08010810, 0x08010812,
      0x00000110, 0x00000112, 0x00000910, 0x00000912,
      0x08000110, 0x08000112, 0x08000910, 0x08000912,
      0x00010110, 0x00010112, 0x00010910, 0x00010912,
      0x08010110, 0x08010112, 0x08010910, 0x08010912
  }
      , {
      0x00000000, 0x00000004, 0x00001000, 0x00001004,
      0x10000000, 0x10000004, 0x10001000, 0x10001004,
      0x00000020, 0x00000024, 0x00001020, 0x00001024,
      0x10000020, 0x10000024, 0x10001020, 0x10001024,
      0x00080000, 0x00080004, 0x00081000, 0x00081004,
      0x10080000, 0x10080004, 0x10081000, 0x10081004,
      0x00080020, 0x00080024, 0x00081020, 0x00081024,
      0x10080020, 0x10080024, 0x10081020, 0x10081024,
      0x20000000, 0x20000004, 0x20001000, 0x20001004,
      0x30000000, 0x30000004, 0x30001000, 0x30001004,
      0x20000020, 0x20000024, 0x20001020, 0x20001024,
      0x30000020, 0x30000024, 0x30001020, 0x30001024,
      0x20080000, 0x20080004, 0x20081000, 0x20081004,
      0x30080000, 0x30080004, 0x30081000, 0x30081004,
      0x20080020, 0x20080024, 0x20081020, 0x20081024,
      0x30080020, 0x30080024, 0x30081020, 0x30081024
  }
      , {
      0x00000000, 0x00100000, 0x00000008, 0x00100008,
      0x00000200, 0x00100200, 0x00000208, 0x00100208,
      0x04000000, 0x04100000, 0x04000008, 0x04100008,
      0x04000200, 0x04100200, 0x04000208, 0x04100208,
      0x00002000, 0x00102000, 0x00002008, 0x00102008,
      0x00002200, 0x00102200, 0x00002208, 0x00102208,
      0x04002000, 0x04102000, 0x04002008, 0x04102008,
      0x04002200, 0x04102200, 0x04002208, 0x04102208,
      0x00020000, 0x00120000, 0x00020008, 0x00120008,
      0x00020200, 0x00120200, 0x00020208, 0x00120208,
      0x04020000, 0x04120000, 0x04020008, 0x04120008,
      0x04020200, 0x04120200, 0x04020208, 0x04120208,
      0x00022000, 0x00122000, 0x00022008, 0x00122008,
      0x00022200, 0x00122200, 0x00022208, 0x00122208,
      0x04022000, 0x04122000, 0x04022008, 0x04122008,
      0x04022200, 0x04122200, 0x04022208, 0x04122208
  }
      , {
      0x00000000, 0x00000200, 0x00020000, 0x00020200,
      0x00000001, 0x00000201, 0x00020001, 0x00020201,
      0x08000000, 0x08000200, 0x08020000, 0x08020200,
      0x08000001, 0x08000201, 0x08020001, 0x08020201,
      0x00200000, 0x00200200, 0x00220000, 0x00220200,
      0x00200001, 0x00200201, 0x00220001, 0x00220201,
      0x08200000, 0x08200200, 0x08220000, 0x08220200,
      0x08200001, 0x08200201, 0x08220001, 0x08220201,
      0x00000002, 0x00000202, 0x00020002, 0x00020202,
      0x00000003, 0x00000203, 0x00020003, 0x00020203,
      0x08000002, 0x08000202, 0x08020002, 0x08020202,
      0x08000003, 0x08000203, 0x08020003, 0x08020203,
      0x00200002, 0x00200202, 0x00220002, 0x00220202,
      0x00200003, 0x00200203, 0x00220003, 0x00220203,
      0x08200002, 0x08200202, 0x08220002, 0x08220202,
      0x08200003, 0x08200203, 0x08220003, 0x08220203
  }
      , {
      0x00000000, 0x00000010, 0x20000000, 0x20000010,
      0x00100000, 0x00100010, 0x20100000, 0x20100010,
      0x00000800, 0x00000810, 0x20000800, 0x20000810,
      0x00100800, 0x00100810, 0x20100800, 0x20100810,
      0x04000000, 0x04000010, 0x24000000, 0x24000010,
      0x04100000, 0x04100010, 0x24100000, 0x24100010,
      0x04000800, 0x04000810, 0x24000800, 0x24000810,
      0x04100800, 0x04100810, 0x24100800, 0x24100810,
      0x00000004, 0x00000014, 0x20000004, 0x20000014,
      0x00100004, 0x00100014, 0x20100004, 0x20100014,
      0x00000804, 0x00000814, 0x20000804, 0x20000814,
      0x00100804, 0x00100814, 0x20100804, 0x20100814,
      0x04000004, 0x04000014, 0x24000004, 0x24000014,
      0x04100004, 0x04100014, 0x24100004, 0x24100014,
      0x04000804, 0x04000814, 0x24000804, 0x24000814,
      0x04100804, 0x04100814, 0x24100804, 0x24100814
  }
      , {
      0x00000000, 0x00001000, 0x00010000, 0x00011000,
      0x02000000, 0x02001000, 0x02010000, 0x02011000,
      0x00000020, 0x00001020, 0x00010020, 0x00011020,
      0x02000020, 0x02001020, 0x02010020, 0x02011020,
      0x00040000, 0x00041000, 0x00050000, 0x00051000,
      0x02040000, 0x02041000, 0x02050000, 0x02051000,
      0x00040020, 0x00041020, 0x00050020, 0x00051020,
      0x02040020, 0x02041020, 0x02050020, 0x02051020,
      0x00002000, 0x00003000, 0x00012000, 0x00013000,
      0x02002000, 0x02003000, 0x02012000, 0x02013000,
      0x00002020, 0x00003020, 0x00012020, 0x00013020,
      0x02002020, 0x02003020, 0x02012020, 0x02013020,
      0x00042000, 0x00043000, 0x00052000, 0x00053000,
      0x02042000, 0x02043000, 0x02052000, 0x02053000,
      0x00042020, 0x00043020, 0x00052020, 0x00053020,
      0x02042020, 0x02043020, 0x02052020, 0x02053020
  }
      , {
      0x00000000, 0x00000400, 0x01000000, 0x01000400,
      0x00000100, 0x00000500, 0x01000100, 0x01000500,
      0x10000000, 0x10000400, 0x11000000, 0x11000400,
      0x10000100, 0x10000500, 0x11000100, 0x11000500,
      0x00080000, 0x00080400, 0x01080000, 0x01080400,
      0x00080100, 0x00080500, 0x01080100, 0x01080500,
      0x10080000, 0x10080400, 0x11080000, 0x11080400,
      0x10080100, 0x10080500, 0x11080100, 0x11080500,
      0x00000008, 0x00000408, 0x01000008, 0x01000408,
      0x00000108, 0x00000508, 0x01000108, 0x01000508,
      0x10000008, 0x10000408, 0x11000008, 0x11000408,
      0x10000108, 0x10000508, 0x11000108, 0x11000508,
      0x00080008, 0x00080408, 0x01080008, 0x01080408,
      0x00080108, 0x00080508, 0x01080108, 0x01080508,
      0x10080008, 0x10080408, 0x11080008, 0x11080408,
      0x10080108, 0x10080508, 0x11080108, 0x11080508
  }
  };
  private static final int spbox[][] = {
      { // s boxes and p box
      0x00808200, 0x00000000, 0x00008000, 0x00808202,
      0x00808002, 0x00008202, 0x00000002, 0x00008000,
      0x00000200, 0x00808200, 0x00808202, 0x00000200,
      0x00800202, 0x00808002, 0x00800000, 0x00000002,
      0x00000202, 0x00800200, 0x00800200, 0x00008200,
      0x00008200, 0x00808000, 0x00808000, 0x00800202,
      0x00008002, 0x00800002, 0x00800002, 0x00008002,
      0x00000000, 0x00000202, 0x00008202, 0x00800000,
      0x00008000, 0x00808202, 0x00000002, 0x00808000,
      0x00808200, 0x00800000, 0x00800000, 0x00000200,
      0x00808002, 0x00008000, 0x00008200, 0x00800002,
      0x00000200, 0x00000002, 0x00800202, 0x00008202,
      0x00808202, 0x00008002, 0x00808000, 0x00800202,
      0x00800002, 0x00000202, 0x00008202, 0x00808200,
      0x00000202, 0x00800200, 0x00800200, 0x00000000,
      0x00008002, 0x00008200, 0x00000000, 0x00808002
  }
      , {
      0x40084010, 0x40004000, 0x00004000, 0x00084010,
      0x00080000, 0x00000010, 0x40080010, 0x40004010,
      0x40000010, 0x40084010, 0x40084000, 0x40000000,
      0x40004000, 0x00080000, 0x00000010, 0x40080010,
      0x00084000, 0x00080010, 0x40004010, 0x00000000,
      0x40000000, 0x00004000, 0x00084010, 0x40080000,
      0x00080010, 0x40000010, 0x00000000, 0x00084000,
      0x00004010, 0x40084000, 0x40080000, 0x00004010,
      0x00000000, 0x00084010, 0x40080010, 0x00080000,
      0x40004010, 0x40080000, 0x40084000, 0x00004000,
      0x40080000, 0x40004000, 0x00000010, 0x40084010,
      0x00084010, 0x00000010, 0x00004000, 0x40000000,
      0x00004010, 0x40084000, 0x00080000, 0x40000010,
      0x00080010, 0x40004010, 0x40000010, 0x00080010,
      0x00084000, 0x00000000, 0x40004000, 0x00004010,
      0x40000000, 0x40080010, 0x40084010, 0x00084000
  }
      , {
      0x00000104, 0x04010100, 0x00000000, 0x04010004,
      0x04000100, 0x00000000, 0x00010104, 0x04000100,
      0x00010004, 0x04000004, 0x04000004, 0x00010000,
      0x04010104, 0x00010004, 0x04010000, 0x00000104,
      0x04000000, 0x00000004, 0x04010100, 0x00000100,
      0x00010100, 0x04010000, 0x04010004, 0x00010104,
      0x04000104, 0x00010100, 0x00010000, 0x04000104,
      0x00000004, 0x04010104, 0x00000100, 0x04000000,
      0x04010100, 0x04000000, 0x00010004, 0x00000104,
      0x00010000, 0x04010100, 0x04000100, 0x00000000,
      0x00000100, 0x00010004, 0x04010104, 0x04000100,
      0x04000004, 0x00000100, 0x00000000, 0x04010004,
      0x04000104, 0x00010000, 0x04000000, 0x04010104,
      0x00000004, 0x00010104, 0x00010100, 0x04000004,
      0x04010000, 0x04000104, 0x00000104, 0x04010000,
      0x00010104, 0x00000004, 0x04010004, 0x00010100
  }
      , {
      0x80401000, 0x80001040, 0x80001040, 0x00000040,
      0x00401040, 0x80400040, 0x80400000, 0x80001000,
      0x00000000, 0x00401000, 0x00401000, 0x80401040,
      0x80000040, 0x00000000, 0x00400040, 0x80400000,
      0x80000000, 0x00001000, 0x00400000, 0x80401000,
      0x00000040, 0x00400000, 0x80001000, 0x00001040,
      0x80400040, 0x80000000, 0x00001040, 0x00400040,
      0x00001000, 0x00401040, 0x80401040, 0x80000040,
      0x00400040, 0x80400000, 0x00401000, 0x80401040,
      0x80000040, 0x00000000, 0x00000000, 0x00401000,
      0x00001040, 0x00400040, 0x80400040, 0x80000000,
      0x80401000, 0x80001040, 0x80001040, 0x00000040,
      0x80401040, 0x80000040, 0x80000000, 0x00001000,
      0x80400000, 0x80001000, 0x00401040, 0x80400040,
      0x80001000, 0x00001040, 0x00400000, 0x80401000,
      0x00000040, 0x00400000, 0x00001000, 0x00401040
  }
      , {
      0x00000080, 0x01040080, 0x01040000, 0x21000080,
      0x00040000, 0x00000080, 0x20000000, 0x01040000,
      0x20040080, 0x00040000, 0x01000080, 0x20040080,
      0x21000080, 0x21040000, 0x00040080, 0x20000000,
      0x01000000, 0x20040000, 0x20040000, 0x00000000,
      0x20000080, 0x21040080, 0x21040080, 0x01000080,
      0x21040000, 0x20000080, 0x00000000, 0x21000000,
      0x01040080, 0x01000000, 0x21000000, 0x00040080,
      0x00040000, 0x21000080, 0x00000080, 0x01000000,
      0x20000000, 0x01040000, 0x21000080, 0x20040080,
      0x01000080, 0x20000000, 0x21040000, 0x01040080,
      0x20040080, 0x00000080, 0x01000000, 0x21040000,
      0x21040080, 0x00040080, 0x21000000, 0x21040080,
      0x01040000, 0x00000000, 0x20040000, 0x21000000,
      0x00040080, 0x01000080, 0x20000080, 0x00040000,
      0x00000000, 0x20040000, 0x01040080, 0x20000080
  }
      , {
      0x10000008, 0x10200000, 0x00002000, 0x10202008,
      0x10200000, 0x00000008, 0x10202008, 0x00200000,
      0x10002000, 0x00202008, 0x00200000, 0x10000008,
      0x00200008, 0x10002000, 0x10000000, 0x00002008,
      0x00000000, 0x00200008, 0x10002008, 0x00002000,
      0x00202000, 0x10002008, 0x00000008, 0x10200008,
      0x10200008, 0x00000000, 0x00202008, 0x10202000,
      0x00002008, 0x00202000, 0x10202000, 0x10000000,
      0x10002000, 0x00000008, 0x10200008, 0x00202000,
      0x10202008, 0x00200000, 0x00002008, 0x10000008,
      0x00200000, 0x10002000, 0x10000000, 0x00002008,
      0x10000008, 0x10202008, 0x00202000, 0x10200000,
      0x00202008, 0x10202000, 0x00000000, 0x10200008,
      0x00000008, 0x00002000, 0x10200000, 0x00202008,
      0x00002000, 0x00200008, 0x10002008, 0x00000000,
      0x10202000, 0x10000000, 0x00200008, 0x10002008
  }
      , {
      0x00100000, 0x02100001, 0x02000401, 0x00000000,
      0x00000400, 0x02000401, 0x00100401, 0x02100400,
      0x02100401, 0x00100000, 0x00000000, 0x02000001,
      0x00000001, 0x02000000, 0x02100001, 0x00000401,
      0x02000400, 0x00100401, 0x00100001, 0x02000400,
      0x02000001, 0x02100000, 0x02100400, 0x00100001,
      0x02100000, 0x00000400, 0x00000401, 0x02100401,
      0x00100400, 0x00000001, 0x02000000, 0x00100400,
      0x02000000, 0x00100400, 0x00100000, 0x02000401,
      0x02000401, 0x02100001, 0x02100001, 0x00000001,
      0x00100001, 0x02000000, 0x02000400, 0x00100000,
      0x02100400, 0x00000401, 0x00100401, 0x02100400,
      0x00000401, 0x02000001, 0x02100401, 0x02100000,
      0x00100400, 0x00000000, 0x00000001, 0x02100401,
      0x00000000, 0x00100401, 0x02100000, 0x00000400,
      0x02000001, 0x02000400, 0x00000400, 0x00100001
  }
      , {
      0x08000820, 0x00000800, 0x00020000, 0x08020820,
      0x08000000, 0x08000820, 0x00000020, 0x08000000,
      0x00020020, 0x08020000, 0x08020820, 0x00020800,
      0x08020800, 0x00020820, 0x00000800, 0x00000020,
      0x08020000, 0x08000020, 0x08000800, 0x00000820,
      0x00020800, 0x00020020, 0x08020020, 0x08020800,
      0x00000820, 0x00000000, 0x00000000, 0x08020020,
      0x08000020, 0x08000800, 0x00020820, 0x00020000,
      0x00020820, 0x00020000, 0x08020800, 0x00000800,
      0x00000020, 0x08020020, 0x00000800, 0x00020820,
      0x08000800, 0x00000020, 0x08000020, 0x08020000,
      0x08020020, 0x08000000, 0x00020000, 0x08000820,
      0x00000000, 0x08020820, 0x00020020, 0x08000020,
      0x08020000, 0x08000800, 0x08000820, 0x00000000,
      0x08020820, 0x00020800, 0x00020800, 0x00000820,
      0x00000820, 0x00020020, 0x08000000, 0x08020800
  }
  };

  /**
  *
  * init method by key value
  */
  public DES(long key) {
    setKey(key);
  }

  /**
  *
  * a byte data to a long data
  */
  public long bytes2long(byte[] rd) {
    long dd = 0;
    for (int i = 0; i <= 7; i++) {
      dd = (dd << 8) | ( (long) rd[i] & 0xff);
    }
    return dd;
  }

  /**
   * Decryption
   * @param long d 	Ciphertext
   * @return long 	Plaintext
   */
  public long decrypt(long d) {
    d = ip(d);
    int l = (int) (d >>> 32);
    int r = (int) d;

    for (int i = 15; i >= 0; i--) {
      int t = l;
      l = r;
      r = t;
      int t1 = ( (r >>> 3) | (r << 29)) ^ subkey1[i];
      int t2 = ( (r << 1) | (r >>> 31)) ^ subkey2[i];
      l ^= spbox[0][ (t1 >>> 24) & 0x3f] | spbox[1][ (t2 >>> 24) & 0x3f] |
          spbox[2][ (t1 >>> 16) & 0x3f] | spbox[3][ (t2 >>> 16) & 0x3f] |
          spbox[4][ (t1 >>> 8) & 0x3f] | spbox[5][ (t2 >>> 8) & 0x3f] |
          spbox[6][ (t1) & 0x3f] | spbox[7][ (t2) & 0x3f];
    }

    d = ( (long) l << 32) | ( (long) r & 0xffffffffL);
    return rip(d);
  }

  /**
   * Encryption 
   * @param long d 	Plaintext
   * @return long 	Ciphertext
   */
  public long encrypt(long d) {
    d = ip(d);
    int l = (int) (d >>> 32);
    int r = (int) d;

    for (int i = 0; i <= 15; i++) {
      int t1 = ( (r >>> 3) | (r << 29)) ^ subkey1[i];
      int t2 = ( (r << 1) | (r >>> 31)) ^ subkey2[i];
      l ^= spbox[0][ (t1 >>> 24) & 0x3f] | spbox[1][ (t2 >>> 24) & 0x3f] |
          spbox[2][ (t1 >>> 16) & 0x3f] | spbox[3][ (t2 >>> 16) & 0x3f] |
          spbox[4][ (t1 >>> 8) & 0x3f] | spbox[5][ (t2 >>> 8) & 0x3f] |
          spbox[6][ (t1) & 0x3f] | spbox[7][ (t2) & 0x3f];
      int t = l;
      l = r;
      r = t;
    }

    d = ( (long) l << 32) | ( (long) r & 0xffffffffL);
    return rip(d);
  }

  /**
   *		initial permutation
   */
  private long ip(long d) {
    long t;
    t = ( (d << 36) ^ d) & 0xf0f0f0f000000000L;
    d ^= (t >>> 36) | t;
    t = ( (d << 48) ^ d) & 0xffff000000000000L;
    d ^= (t >>> 48) | t;
    t = ( (d << 30) ^ d) & 0x3333333300000000L;
    d ^= (t >>> 30) | t;
    t = ( (d << 24) ^ d) & 0x00ff00ff00000000L;
    d ^= (t >>> 24) | t;
    t = ( (d << 33) ^ d) & 0xaaaaaaaa00000000L;
    d ^= (t >>> 33) | t;
    return d;
  }

  /**
  *
  *	long to array of byte
  */
  public void long2bytes(long sd, byte[] dd) {
    for (int i = 7; i >= 0; i--) {
      dd[i] = (byte) sd;
      sd >>>= 8;
    }
  }

  /**
   *		reverse initial permutation
   */
  private long rip(long d) {
    long t;
    t = ( (d << 33) ^ d) & 0xaaaaaaaa00000000L;
    d ^= (t >>> 33) | t;
    t = ( (d << 24) ^ d) & 0x00ff00ff00000000L;
    d ^= (t >>> 24) | t;
    t = ( (d << 30) ^ d) & 0x3333333300000000L;
    d ^= (t >>> 30) | t;
    t = ( (d << 48) ^ d) & 0xffff000000000000L;
    d ^= (t >>> 48) | t;
    t = ( (d << 36) ^ d) & 0xf0f0f0f000000000L;
    d ^= (t >>> 36) | t;
    return d;
  }

  /**
   *	set password key 
   *
   */
  public void setKey(long key) {
    long t;
    t = ( (key << 36) ^ key) & 0xf0f0f0f000000000L;
    key ^= (t >>> 36) | t;
    t = ( (key << 18) ^ key) & 0xcccc0000cccc0000L;
    key ^= t | (t >>> 18);
    t = ( (key << 9) ^ key) & 0xaa00aa00aa00aa00L;
    key ^= t | (t >>> 9);

    int d = (int) ( (key >>> 28) & 0x0ffffff0 | (key >>> 24) & 0x0000000f);
    int c = (int) ( (key << 20) & 0x0ff00000 | (key << 4) & 0x000ff000 |
                   (key >>> 12) & 0x00000ff0 | (key >>> 28) & 0x0000000f);

    for (int i = 0; i < 16; i++) {
      if (ks[i]) {
        c = ( (c << 2) | (c >>> 26)) & 0x0fffffff;
        d = ( (d << 2) | (d >>> 26)) & 0x0fffffff;
      }
      else {
        c = ( (c << 1) | (c >>> 27)) & 0x0fffffff;
        d = ( (d << 1) | (d >>> 27)) & 0x0fffffff;
      }
      int t1 = kp[0][ (c >>> 22) & 0x3f] |
          kp[1][ (c >>> 16) & 0x30 | (c >>> 15) & 0x0f] |
          kp[2][ (c >>> 9) & 0x3c | (c >>> 8) & 0x03] |
          kp[3][ (c >>> 3) & 0x20 | (c >>> 1) & 0x18 | c & 0x07];
      int t2 = kp[4][ (c >>> 22) & 0x3f] |
          kp[5][ (c >>> 15) & 0x30 | (c >>> 14) & 0x0f] |
          kp[6][ (c >>> 7) & 0x3f] |
          kp[7][ (c >>> 1) & 0x3c | c & 0x03];
      subkey1[i] = (t1 & 0xff000000) | ( (t1 & 0x0000ff00) << 8) |
          ( (t2 & 0xff000000) >>> 16) | ( (t2 & 0x0000ff00) >>> 8);
      subkey2[i] = ( (t1 & 0x00ff0000) << 8) | ( (t1 & 0x000000ff) << 16) |
          ( (t2 & 0x00ff0000) >>> 8) | (t2 & 0x000000ff);
    }
  }
}