# ShoppingList
RestApi to create a shopping list.
You can create and delete products and shopping lists, add products to shopping lists.

The following tables need to be created in the database:
create table products
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    name        varchar(255) null,
    quantity    int          not null
);

create table shopping_lists
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table shopping_lists_product_list
(
    shopping_list_id bigint not null,
    product_list_id  bigint not null,
    constraint FKadi23vitbyc9lw88xkcoowq0c
        foreign key (product_list_id) references products (id),
    constraint FKhbdbjnle2ffkgjlbuoa1317ae
        foreign key (shopping_list_id) references shopping_lists (id)
);
