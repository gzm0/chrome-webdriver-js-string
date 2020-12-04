import org.openqa.selenium.chrome.ChromeDriver;

object Test {
  def main(args: Array[String]): Unit = {
    System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
    System.setProperty("webdriver.chrome.verboseLogging", "true");

    val driver = new ChromeDriver()
    try {
      val data = driver.executeScript("return \"\u0000\u007F\u0061\u0001\";").asInstanceOf[String]
      for ((c, i) <- data.zipWithIndex) {
        val hexStr = Integer.toHexString(c.toInt)
        println(f"$i: 0x$hexStr")
      }
    } finally {
      driver.close()
    }
  }
}
