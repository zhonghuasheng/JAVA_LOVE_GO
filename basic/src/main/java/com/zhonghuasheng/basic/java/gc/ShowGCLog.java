package com.zhonghuasheng.basic.java.gc;

/**
 * 通过配置JVM参数来显示GC的日志
 */
public class ShowGCLog {

    public static void main(String[] args) {
        Object obj = new Object();
        System.gc();
        System.out.println();
        obj = new Object();
        obj = new Object();
        System.gc();
        System.out.println();
        /*
        "C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -XX:+PrintGCDetails -javaagent:I:\Dev-Tool\ideaIU-2018.2.2.win\lib\idea_rt.jar=53862:I:\Dev-Tool\ideaIU-2018.2.2.win\bin -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_111\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\servlet-api.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\rt.jar;I:\workspace\JAVA\basic\target\classes;C:\Users\Ant\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar" com.zhonghuasheng.basic.java.gc.ShowGCLog
        [GC (System.gc()) [PSYoungGen: 3948K->776K(57344K)] 3948K->784K(188416K), 0.0034954 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
        [Full GC (System.gc()) [PSYoungGen: 776K->0K(57344K)] [ParOldGen: 8K->671K(131072K)] 784K->671K(188416K), [Metaspace: 3482K->3482K(1056768K)], 0.0074356 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]

        [GC (System.gc()) [PSYoungGen: 983K->32K(57344K)] 1655K->703K(188416K), 0.0004907 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [Full GC (System.gc()) [PSYoungGen: 32K->0K(57344K)] [ParOldGen: 671K->663K(131072K)] 703K->663K(188416K), [Metaspace: 3484K->3484K(1056768K)], 0.0087075 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]

        Heap
         PSYoungGen      total 57344K, used 1474K [0x0000000780780000, 0x0000000784780000, 0x00000007c0000000)
          eden space 49152K, 3% used [0x0000000780780000,0x00000007808f0bf8,0x0000000783780000)
          from space 8192K, 0% used [0x0000000783f80000,0x0000000783f80000,0x0000000784780000)
          to   space 8192K, 0% used [0x0000000783780000,0x0000000783780000,0x0000000783f80000)
         ParOldGen       total 131072K, used 663K [0x0000000701600000, 0x0000000709600000, 0x0000000780780000)
          object space 131072K, 0% used [0x0000000701600000,0x00000007016a5f50,0x0000000709600000)
         Metaspace       used 3491K, capacity 4498K, committed 4864K, reserved 1056768K
          class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
        * */
    }
}
