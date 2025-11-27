#!/bin/bash

cd /home/ubuntu/ticketbay

# 기존 프로세스 종료
PID=$(lsof -ti :8080)
if [ -n "$PID" ]; then
  kill -9 $PID
fi

# 새 버전 실행
nohup java -jar *.jar > app.log 2>&1 &
