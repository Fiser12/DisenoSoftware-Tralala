CREATE DATABASE tralala;

GRANT ALTER,SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON tralala.*
           TO sd@'%'
           IDENTIFIED BY 'sd';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON tralala.*
           TO sd@localhost
           IDENTIFIED BY 'sd';