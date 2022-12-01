# Upstair! Alpha

> 업스테어! 알파 버전

제작자: 경상대 컴퓨터과학과 황승현

- 계단 오르기 기록 관리 애플리케이션

- 계단 오르기로 돈 벌자!! X2E, 블록체인, 메타버스, 헬스케어 애플리케이션



## DB

게시글 DB

|     | 이름     | Name     | Type     | Key |
| --- | ------ | -------- | -------- | --- |
| 1   | 게시글 ID | postID   | INTEGER  | P.K |
| 2   | 작성일    | postDate | DATETIME |     |
| 3   | 게시글 내용 | content  | TEXT     |     |
| 4   | 게시 사진  | picture  | IMAGE    |     |

사용자 DB

|     | 이름       | Name     | Type     | Key |
| --- | -------- | -------- | -------- | --- |
| 1   | 사용자 ID   | userID   | INTEGER  | P.K |
| 2   | 가입일      | regDate  | DATETIME |     |
| 3   | 나이       | age      | INTEGER  |     |
| 4   | 성별       | sex      | INTEGER  |     |
| 5   | 운동 목표 시간 | goalTime | INTEGER  |     |
| 6   | 코인       | coin     | DOUBLE   |     |
