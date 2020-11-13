$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Chrome failed to start: exited normally.\n  (unknown error: DevToolsActivePort file doesn\u0027t exist)\n  (The process started from chrome location C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe is no longer running, so ChromeDriver is assuming that Chrome has crashed.)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-DJC8OLDO\u0027, ip: \u0027192.168.1.155\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tOrdinal0 [0x00F9C013+3194899]\n\tOrdinal0 [0x00E86021+2056225]\n\tOrdinal0 [0x00D1F608+587272]\n\tOrdinal0 [0x00C9E5D2+58834]\n\tOrdinal0 [0x00C9C64A+50762]\n\tOrdinal0 [0x00CC1EE9+204521]\n\tOrdinal0 [0x00CC1D0D+204045]\n\tOrdinal0 [0x00CBFC1B+195611]\n\tOrdinal0 [0x00CA3B7F+80767]\n\tOrdinal0 [0x00CA4B4E+84814]\n\tOrdinal0 [0x00CA4AD9+84697]\n\tOrdinal0 [0x00E9CE64+2149988]\n\tGetHandleVerifier [0x0110BE95+1400773]\n\tGetHandleVerifier [0x0110BB61+1399953]\n\tGetHandleVerifier [0x011131FA+1430314]\n\tGetHandleVerifier [0x0110C69F+1402831]\n\tOrdinal0 [0x00E93D61+2112865]\n\tOrdinal0 [0x00E9E5CB+2155979]\n\tOrdinal0 [0x00E9E6F5+2156277]\n\tOrdinal0 [0x00EAF26E+2224750]\n\tBaseThreadInitThunk [0x77786359+25]\n\tRtlGetAppContainerNamedObjectPath [0x77BF7C24+228]\n\tRtlGetAppContainerNamedObjectPath [0x77BF7BF4+180]\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$errorHandler$0(W3CHandshakeResponse.java:62)\r\n\tat org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)\r\n\tat java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)\r\n\tat java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:74)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:136)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\r\n\tat com.hrms.testbase.BaseClass.setUp(BaseClass.java:46)\r\n\tat com.hrms.stepDefinitions.Hooks.startTest(Hooks.java:18)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "login with invalid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_invalid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify the error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.verify_the_error_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat com.hrms.utils.CommonMethods.takeScreenshot(CommonMethods.java:247)\r\n\tat com.hrms.stepDefinitions.Hooks.endTest(Hooks.java:29)\r\n",
  "status": "failed"
});
});