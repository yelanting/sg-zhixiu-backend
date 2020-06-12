use `sg_zhixiu_order`;
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
   table_schema = 'sg_zhixiu_order';
SET FOREIGN_KEY_CHECKS= 0;