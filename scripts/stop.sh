#!/bin/bash

# 포트 8080에서 실행 중인 Spring Boot 종료
PID=$(lsof -ti :8080)
if [ -n "$PID" ]; then
  kill -9 $PID
fi

echo "Spring Boot app stopped."
