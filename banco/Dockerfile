FROM postgres
ENV POSTGRES_DB app-vendas
ENV POSTGRES_USER usuario
ENV POSTGRES_PASSWORD 1234

COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/