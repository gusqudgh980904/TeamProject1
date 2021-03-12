set dev_home=c:/dev
set java_home=%dev_home%/java-14-openjdk-14.0.1-1
set eclipse_home=%dev_home%/eclipse

set path=%java_home%/bin;%eclipse_home%


rem XXX_home, path, classpath 3가지의 환경변수를 설정.
rem XXX_home : 설치된 프로그램 끼리 경로를 참조할 때.
rem         path : 설치된 프로그램을 경로에 상관없이 사용하기위해 path를 설정.
rem   classpath : class파일 (bytecode)를 경로에 상관없이 사용하기 위해 설정. 