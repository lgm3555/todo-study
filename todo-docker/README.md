# todo-docker

#도커

컨테이너를 사용하여 응용프로그램을 더 쉽게 만들고 배포하고 실행할 수 있도록 설계된 도구이며 컨테이너 기반의 오픈소스 가상화 플랫폼

#도커 컨테이너

컨테이너는 코드와 모든 종속성을 패키지화하여 응용 프로그램이 한 컴퓨팅 환경에서 다른 컴퓨팅 환경으로 빠르고 안정적으로 실행되도록 하는 소프트웨어 표준 단위

	> 간단하고 편리하게 프로그램을 실행시켜주는 것으로 정의

#도커 이미지

코드, 런타임, 시스템 도구, 시스템 라이브러리 및 설정과 같은 응용 프로그램을 실행하는데 필요한 모든 것을 포함하는 가볍고 독립적이며 실행 가능한 소프트웨어 패키지

	> 프로그램을 실행하는데 필요한 설정이나 종속성을 가지고 있음

#도커 이미지 <ㅡ> 도커 컨테이너

도커 이미지를 이용하여 컨테이너를 생성, 도커 컨테이너를 이용하여 프로그램 실행

#도커 vs vm

공통점: 도커 컨테이너와 가상머신은 기본 하드웨어에서 격리된 환경 내에 애플리케이션을 배치하는 방법

차이점: 가장 큰 차이점은 격리된 환경을 얼마나 격리를 시키는지의 차이

#docker hub에서 받아오기

docker pull <이미지>


#docker ex

	#node image 다운
  
	docker pull node
  
	#다운로드한 이미지 컨테이너화
  
	docker run -d -it --name=nodejs_test node:lastest
  
	#컨테이너 실행 확인
  
	docker ps
  
	#소스코드 내부로 복사
  
	docker cp nodejs_test.js nodejs_test:/nodejs_test.js
  
	#실행중인 npm이 설치된 nodejs_test 컨테이너에 bash 쉘로 접속
  
	docker exec -it nodejs_test /bin/bash
	
  
Docker Engine : 도커를 이용한 애플리케이션 실행 환경 제공을 위한 핵심 요소

Docker Hub : 전 세게 독커 사용자들과 함께 도커 컨테이너 이미지를 공유하는 클라우드 서비스

Docker-compose : 의존성 잇는 독립된 컨테이너에 대한 구성 정보를 야믈YAML 코드로 작성하여 일원화된 어플리케이션 관리를 가능하게 하는 도구

Docker Kitematic : 컨테이너를 이용한 작업을 수행할 수 있는 GUI 제공을

Docker Registry : 도커 허브 사이트를 공개된 레지스트리라고 보면 됨

Docker Machine : 가상머신 프로그램 및 AWS EC2, MS Azure 환경에서 도커 실행 환경을 생성하기 위한 도구

Docker Swarm : 여러 도커 호스트를 클러스트로 구축하여 관리할 수 있는 도커 오케스트레이션 도구


#docker pull : 도커 허브 레파지토리에서 로컬로 도커 이미지 내려받기

#docker push : 로컬에 있는 도커 이미지를 도커 허브 레지스트리에 업로드하기

#docker login : 업로드 하기 전 도커 허브 계정으로 로그인 수행하기

#docker logout : 도커 허브에서 로그아웃 하기



#이미지로 컨테이너 만들기

docker run <이미지>

	docker create + docker start 

	ex) docker run alpine ls
  
	docker: 도커 클라이언트 언급
  
	run: 컨테이너 생성 및 실행
  
	alpine: 이 컨테이너를 위한 이미지
  
	ls: 이미지의 기본 시작 명령어 대신 실행할 명령어
  

	ex) docker run hello-world
  
	1. 도커 클라이언트에 해당 커맨드를 입력하면 도커 서버로 요청을 보냄
  
	2. hello-world라는 이미지가 로컬 cache에 있는지 확인
  
	3. 없는 경우 Unable to find image ~라는 문구가 2번째 줄에 표시
  
	4. 그러면 Docker Hub라는 이미지가 저장되어 있는 곳에 가서 그 이미지를 가져오고 로컬 cache로 보관
  
	5. 그 후 이제는 이미지가 있으니 그 이미지를 이용해서 컨테이너를 생성


#컨테이너 나열

	#현재 실행중인 컨테이너 나열
  
	docker ps

	#모든 컨테이너 나열
  
	docker ps -a

		CONTAINER ID: 컨테이너의 고유한 아이디 해쉬값. 실제로는 더욱 길지만 일부분만 표출
    
		IMAGE: 컨테이너 생성 시 사용한 도커 이미지
    
		COMMAND: 컨테이너 시작시 실행될 명령어, 대부분 이미지에 내장되어 있으므로 별도 설정 필요 X
    
		CREATED: 컨테이너 생성된 시간
    
		STATUS: 컨테이너의 상태, 실행중: Up, 종료: Exited, 일시정지: Pause
    
		PORTS: 컨테이너가 개방한 포트와 호스트에 연결한 포트
    
		NAMES: 컨테이너 고유한 이름, 컨테이너 생성시 --name 옵션으로 이름을 설정하지 않으면 도커 엔진에서 임의로 생성
    

#컨테이너 실행

docker run <이미지 이름> : docker create <이미지 이름> + docker start <컨테이너 아이디/이름>

#컨테이너 중지

	docker stop <컨테이너 아이디/이름>: Gracefully하게 중지 -> 하던 작업들 완수하고 중지
  
	docker kill <컨테이너 아이디/이름>: 바로 중지

#컨테이너 삭제

docker rm <아이디/이름> : 실행 중인 컨테이너는 먼저 중지한 후에 삭제 가능

#이미지 삭제

docker image rm <이미지 REPOSITORY:태그명>

docker rmi <이미지 id>

#구동중이지 않는 이미지 삭제

docker image prune -a

#컨테이너, 이미지 모두 삭제

docker system prune

#새로 컨테이너를 만들어 실행

docker run

#이미 실행중인 컨테이너 명령어 전달

docker exec

ex) docker exec -it 컨테이너 아이디 명령어

-it: interactive, terminal 명령어 실행한 후 계속 명령어 사용 가능

#도커 이미지 확인

docker images

#도커 이미지 전체 확인

docker images -a

#도커 이미지 삭제

docker rmi <IMAGE ID>

#도커 이미지 빌드 이름 주기

docker build -t lgm3555/nodejs ./

#도커 컨테이너 확인

docker ps

#도커 컨테이너 전체 확인

docker ps -a

#도커 run

docker run -d -p 8080:8080 -v C:/Users/todo-docker/nodejs-docker-app:/usr/src/app lgm3555/nodejs

#도커 중단

docker stop <CONTAINER ID>

#도커 볼륨 생성

docker volume create <볼륨명>

docker create -v <볼륨명>

#도커 볼륨 조회

docker volume ls

#도커 볼륨 스팩

docker volume inspect 볼명

docker volume inspect --format="{{ .Mounts }}" vol-test1

#도커 볼륨 제거

docker volume rm 볼륨명

#도커 볼륨 공유 옵션

--volumes-from <볼륨명>


#Dockerfile

도커 이미지를 만들기 위한 설정 파일이며, 컨테이너가 어떻게 행동해야 하는지에 대한 설정들을 정의해 주는 곳

명령어는 대소문자를 구분하지 않지만 가독성을 위해 대문자로 작성

1. FROM (필수)

생성하려는 이미지의 베이스 이미지 지정으로 hub.docker.com에서 제공하는 공식 이미지를 권장하며 이미지 태그는 도커 허브에서 여러 태그가 버전 정보로 제공됨

ex) FROM ubuntu:20.04

2. MAINTAINER

일반적으로 이미지를 빌드한 작성자 이름과 이메일을 작성

3. LABEL

이미지 작성 목적으로 버전 타이틀

#Dockerfile 작성 예시

	#베이스 이미지를 명시
  
	FROM baseImage
  
	#추가적으로 필요한 파일들을 다운로드 받음
  
	RUN command
  
	#컨테이너 시작시 실행 될 명령어를 명시
  
	CMD ["executable"]

	FROM: 기반이 되는 이미지 레이어 <이미지 이름>:<태그> (ex) ubuntu:14.04))
  
	MAINTAINER: 메인테이너 정보
  
	RUN: 도커이미지가 생성되기 전에 수행될 쉘 명령어
  
	VOLUME: 디렉터리의 내용을 컨테이너에 저장하지 않고 호스트에 저장하도록 설정 
  
		데이터 볼륨을 호스트의 특정 디렉터리와 연결하려면 docker run 명령에서 -v 옵션 사용
    
		(ex) -v /root/data:/data))
    
	CMD: 컨테이너가 시작되었을 때 실행할 실행 파일 또는 쉘 스크립트
  
	WORKDIR: CMD에서 설정한 실행 파일이 실행될 디렉터리
  
	EXPOSE: 호스트와 연결할 포트 번호



#포트 맵핑

docker run -p 49160:8080 <이미지 이름>


#멀티 컨테이너 상황에서 쉽게 네트워크를 연결해주기 위해서 docker compose 이용

#docker-compose.yml 작성 예시

	version: "3"
  
	services:
  
		redis-server:
    
			image: "redis"
      
		node-app:

			build:
      
			ports:
      
				- "5000:8080"

	version: 도커 컴포즈 비전
  
	services: 이곳에 실행하려는 컨테이너 정의
  
		redis-server: 컨테이너 이름
    
			image: 컨테이너에서 사용하는 이미지 이름
      
		node-app: 컨테이너 이름
    
			build: 현 디렉토리에 있는 Dockfile 용
      
			ports: 포트 맵핑 로컬 포트:컨테이너 포트
      

#docker-compose build: 이미지 빌드하며, 컨테이너 실행 안함

#docker-compose up: 이미지가 존재하지 않을 경우에만 빌드하며, 컨테이너 실행

#docker-compose up --build: 필요치 않을때도 강제로 이미지를 빌드하며, 컨테이너 실행

#docker-compose up --no --build: 이미지 빌드 없이, 컨테이너를 시작 (이미지 없을 경우 실패)

#docker-compose down: docker-compose를 통해 작동시킨 컨테이너들을 한꺼번에 중단

#docker-compose up -d: detached 모드로서 앱을 백그라운드에서 실행
