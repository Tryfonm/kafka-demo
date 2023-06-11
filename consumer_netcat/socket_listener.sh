#!/bin/bash

while true; do
    received_data=$(nc -l -p 1234)
    echo "Received: $received_data"
done

