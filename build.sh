#!/bin/sh

clj -m cljs.main -t browser -O simple -o main.js -c aws-backups.core && \

cp ./out/main.js ./server/public/main.js
