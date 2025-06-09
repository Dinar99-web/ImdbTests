# Проект по автоматизации тестирования для сервиса [IMDb](https://s.media-imdb.com/)

> IMDB — веб-сайт с крупнейшей в мире базой данных о кинематографе..

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="media/intellij-original.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="media/java-original.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="media/github-original.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="media/junit-original.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="media/gradle-original.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="media/selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="media/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="media/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://www.jenkins.io/"><img src="media/jenkins-original.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Поиск фильма по названию*
- ✓ *Проверка названия поля виджета*
- ✓ *Проверка способов аутентификации*
- ✓ *Поиск по ключевому слову
- ✓ *Поиск по актеру*


____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/jenkins-original.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/035-ducking_duck_imdb_tests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/035-ducking_duck_imdb_tests/"><img src="media/jenkins_report.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*


___
<a id="allure"></a>
## <img alt="Allure" height="25" src="media/Allure_Report.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/035-ducking_duck_imdb_tests/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="media/allure-report.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="media/allure-report2.png" width="850">  
</p>

___ 

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="media/icons8-телеграм.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/telegram_report.png" width="550">  
