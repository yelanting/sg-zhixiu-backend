use sg_zhixiu;
SELECT
   concat

   (
      'DROP TABLE IF EXISTS ',
      table_name,
      ';'
   )
FROM
   information_schema.tables
WHERE
   table_schema = 'sg_zhixiu';
SET FOREIGN_KEY_CHECKS= 0;