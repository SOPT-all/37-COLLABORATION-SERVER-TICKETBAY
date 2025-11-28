#!/bin/bash

PID=$(lsof -ti :8080)
if [ -n "$PID" ]; then
  kill -9 $PID
fi
