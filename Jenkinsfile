pipeline {
	agent any
	stages {
		stage('Checkout') {
			steps {
				// 소스코드 체크아웃
				checkout scm
			}
		}
		stage('Build') {
			steps {
				// Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
				// window 일 경우 bat
				// bat 'javac -encoding UTF-8 -d classes BookSearch/src/**/*.java'
				//bat 'javac -encoding UTF-8 -d classes BookSearch/src/com/example/booksearch/*.java'
				//bat 'javac -cp "C:/Users/Kwak/eclipse/java-2024-06/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar" BookSearch/src/com/example/booksearch/BookSearch.java BookSearch/src/com/example/booksearch/BookSearchTest.java'
				// bat 'javac -cp "lib/junit-platform-console-standalone-1.7.1.jar" -encoding UTF-8 -d classes BookSearch/src/com/example/booksearch/BookSearchTest.java'
				bat"cd BookSearch/src"
				bat"""javac -cp "../lib/junit-platform-console-standalone-1.7.1.jar" -encoding UTF-8 -d classes ../src/BookSearch.java ../src/BookSearchTest.java"""
			}
		}
		stage('Test') {
			steps {
				script {
//                    			def classpath = "classes;lib/;C:/Users/Kwak/eclipse/java-2024-06/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar"
//                    			def command = "java -cp \"${classpath}\" org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
//                    			echo "Running command: ${command}"
                    			bat """java -jar ../../lib/junit-platform-console-standalone-1.7.1.jar -cp "." --select-class BookSearchTest --reports-dir='reports'"""
					
			    }
			}
		}
	}
	post {
		always {
			// 테스트 결과 파일을 저장하기 위해 아카이브
			archiveArtifacts 'test_results.txt'
		}
		failure {
			echo "Build or test failed"
		}
		success {
			echo "Build and test succeeded"
		}
	}
}
