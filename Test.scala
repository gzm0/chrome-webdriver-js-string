import org.openqa.selenium.chrome.ChromeDriver;

object Test {
  def main(args: Array[String]): Unit = {
    val driver = new ChromeDriver()
    try {
      val data = driver.executeScript("return \"\u007F\";").asInstanceOf[String]
      println(data.length)
    } finally {
      driver.close()
    }
  }
}
