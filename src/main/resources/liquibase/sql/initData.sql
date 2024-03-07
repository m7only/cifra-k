--liquibase formatted sql

--changeSet skryagin:1
INSERT INTO public.news_type (id, color, title) VALUES (1, 'red', 'титля');
INSERT INTO public.news_type (id, color, title) VALUES (2, 'green', 'титля2');
INSERT INTO public.news_type (id, color, title) VALUES (3, 'blue', 'титля3');
INSERT INTO public.news_type (id, color, title) VALUES (4, 'yellow', 'титьля4');

INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф1', 'контент1', 'титля1', 1);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф2', 'контент2', 'титля2', 1);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф3', 'контент3', 'титля3', 1);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф4', 'контент4', 'титля4', 2);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф5', 'контент5', 'титля5', 2);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф6', 'контент6', 'титля6', 2);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф7', 'контент7', 'титля7', 3);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф8', 'контент8', 'титля8', 4);
INSERT INTO public.news (brief, content, title, news_type_id) VALUES ('бриф9', 'контент9', 'титля9', 4);
