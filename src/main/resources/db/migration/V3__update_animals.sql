UPDATE animals
SET image_url = CASE
                    WHEN type = 'Dogs' THEN 'https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg'
                    WHEN type = 'Cats' THEN 'https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg'
                    WHEN type = 'Turtles' THEN 'https://upload.wikimedia.org/wikipedia/commons/1/1e/Trachemys_scripta_elegans.jpg'
                    WHEN type = 'Birds' THEN 'https://upload.wikimedia.org/wikipedia/commons/3/32/House_sparrow04.jpg'
                    WHEN type = 'Reptiles' THEN 'https://upload.wikimedia.org/wikipedia/commons/b/bc/Green_iguana_iguana.jpg'
    END;
