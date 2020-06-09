use sg_zhixiu_product;
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
   table_schema = 'sg_zhixiu_product';
SET FOREIGN_KEY_CHECKS= 0;