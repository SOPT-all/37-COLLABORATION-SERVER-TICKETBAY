#!/bin/bash

cd /home/ubuntu/ticketbay

# 환경변수 불러오기
source env.list

# env.list 파일 불러오기 (GitHub Actions에서 받아온 Secrets값들)
if [ -f ./env.list ]; then
  export $(cat ./env.list | xargs)
fi

# 기존 프로세스 종료
PID=$(lsof -ti :8080)
if [ -n "$PID" ]; then
  kill -9 $PID
fi

# 새 버전 실행 (환경변수 적용시키는 것 포함)
nohup java -jar ticketbay-0.0.1-SNAPSHOT.jar --spring.profiles.active=$SPRING_PROFILES_ACTIVE > app.log 2>&1 &