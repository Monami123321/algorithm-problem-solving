-- 코드를 입력하세요
SELECT TITLE, USED_GOODS_BOARD.BOARD_ID, REPLY_ID, USED_GOODS_REPLY.WRITER_ID, USED_GOODS_REPLY.CONTENTS, DATE_FORMAT(USED_GOODS_REPLY.CREATED_DATE, "%Y-%m-%d") AS CREATED_DATE
FROM USED_GOODS_BOARD
RIGHT OUTER JOIN USED_GOODS_REPLY 
ON USED_GOODS_BOARD.BOARD_ID = USED_GOODS_REPLY.BOARD_ID
WHERE month(USED_GOODS_BOARD.CREATED_DATE) = 10 AND year(USED_GOODS_BOARD.CREATED_DATE) = 2022

ORDER BY USED_GOODS_REPLY.CREATED_DATE ASC, USED_GOODS_BOARD.TITLE ASC