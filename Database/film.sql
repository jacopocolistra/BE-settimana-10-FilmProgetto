PGDMP     5    4                z            film    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    25455    film    DATABASE     `   CREATE DATABASE film WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE film;
                postgres    false            ?            1259    25457    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    25456    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    25457    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   v       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 7, true);
          public          postgres    false    209            ]           2606    25463    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?     x?]?˒?0?5<E??"??.?^A?v?l"?`?!H??7L?S3?JU????稒?(????UyY??/????0??|0?.m????U?x^EŎNC????rWM$??%?? eBH???L
s?	?˚?NL??$>۾v????ń???p?*4y?%??V?I4J-???J??FR ??Us?$-$?w?;?Y?Ңe? .G??e??'????6?}w7I??]?X?nl??
O??E?&ĺN^??0hV}%A.??o ?(e?Z??N	?$y%?X ??E???Q??ߔ??????????X?H?2?T?H??:V?D??c?W??????4???=XԌ????\3~|r>???'??-\???sR??(}??_܀??(??>x???,B?N?Gjf?????h???)??7?j?os?/=,?S6{?|"??J?s??^y-f??&l?????SٴC%?wchhA?(??,2???.٘?S??Iѷ???s? ??v?fG1? ??8?????,?_ܟߡ     