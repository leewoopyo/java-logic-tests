# java-logic-test
- 다양한 자바 기능을 테스트 하기위한 로직 모음
- jdk 버전 : 17
- 로직을 만들면서 추가로 필요한 라이브러리는 jar를 받아서 .lib 폴더에 넣음 
- 테스트용 DB 는 '.db' 경로에 있음,  github에 올리지는 않음

1. crypt
   - 암복호화 기능
2. connect_db
   - DB 연결하는 기능을 따로 만듦
   - h2db를 활용할 것임 
3. compare_db_tables
   - 두개의 db를 비교
   - 환경(dev, test, stage, prod 등)에 따른 db 테이블들을 비교하고자 만듦
4. change_int_byte
   - Int, Byte 변환
   - TCP 통신을 위해 전문 길이부(int)를 구한 후 이를 byteArray로 바꾸어줘야 하는 경우가 있다.
5. file_read_csv
   - CSV 파일을 읽는 기능 
6. file_read_json
   - CSV 파일을 읽는 기능 
7. serialize
   - 직렬화 테스트
8. redis
   - redis 테스트
   - TODO: docker 설치 후 docker 환경의 redis를 연결할 것임
9. socket
   - 소켓 통신 테스트
   - TCP 통신
   - client, server
10. remove_duplication
   -  중복 제거