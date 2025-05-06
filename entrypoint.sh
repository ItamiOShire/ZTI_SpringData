#!/bin/bash
# Start SQL Server in background
/opt/mssql/bin/sqlservr &

# Wait until MSSQL is ready
echo "Waiting for MSSQL to be ready..."
until /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 1qaz@WSX -Q "SELECT 1" &> /dev/null
do
  sleep 1
done

echo "MSSQL is up. Running init script..."
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 1qaz@WSX -i /init/init.sql

# Wait for SQL Server process to end (to keep the container alive)
/wait