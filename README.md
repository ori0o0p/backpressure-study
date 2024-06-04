# Backpressure
webflux - reactor를 사용한 백프레셔

### 전략

- IGNORE : Backpressure 사용 안 함
- ERROR : Downstream으로 전달할 데이터가 버퍼에 가득 찰 경우, Exception을 발생
- DROP : Downstream으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 밖에서 대기하는 먼저 emit된 데이터부터 Drop
- LATEST : Downstream으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 밖에서 대기하는 가장 최근에(나중에) emit된 데이터부터 버퍼에 저장
- BUFFER : Downstream으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 안에 있는 데이터부터 Drop
