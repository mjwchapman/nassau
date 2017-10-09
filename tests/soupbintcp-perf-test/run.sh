#!/bin/bash
cd "$(dirname "$0")"
java -jar nassau-soupbintcp-perf-test.jar 999999 2>&1 | tee nassau-soupbintcp-perf-test.log
