
# Java Spring Example

A small backend application built using Java Spring and PostgreSQL


## API Reference

#### Get all person

```http
  GET http://localhost:8081/person
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `-` | brings all person |

#### Add Person

```http
  POST http://localhost:8081/person
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `status`      | `string` | **Required**. user's activity status |
| `firstName`      | `string` |  user's name |
| `lastName`      | `string` |  user's lastName  |
| `phone`      | `string` |  user's phone |
| `email`      | `string` | user's email  |
| `addresses`      | `array` | user's address or addresses  |

#### Update Person
```http
  PUT http://localhost:8081/person
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. user's id |
| `status`      | `string` | **Required**. user's activity status |
| `firstName`      | `string` |  user's name |
| `lastName`      | `string` |  user's lastName  |
| `phone`      | `string` |  user's phone |
| `email`      | `string` | user's email  |
| `addresses`      | `array` | user's address or addresses  |

#### Delete Person
```http
  DELETE http://localhost:8081/person
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. user's id |


