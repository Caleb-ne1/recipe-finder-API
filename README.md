# 🍲 Recipe Finder API Documentation

## Table of Contents
1. [Auth API](#auth-api)
   - Create User Account
   - Login
   - Get Session Info
   - Get Current User
2. [Meals API](#meals-api)
   - List All Categories
   - Get Meals by Category
   - Search Meal by Name
   - Filter Meals by Ingredient
   - Lookup Meal by ID
3. [Favorites API](#favorites-api)
   - Add to Favorites
   - Delete from Favorites

---

# Auth API

## Base URL
```
http://localhost:8081/user
```

### Create User Account  
**POST** `/create`  

Creates a new user account.  

#### Request Body
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "mypassword"
}
```

#### Success Response `201 Created`
```json
{
  "message": "User account created successfully",
  "data": {
    "userID": 1,
    "email": "caleb@example.com",
    "createdAt": "2025-08-26T12:30:00Z",
    "updatedAt": "2025-08-26T12:30:00Z"
  }
}
```

#### Error Codes
- `400 Bad Request` – Email or password missing  
- `409 Conflict` – Email already exists  

---

### Login  
**POST** `/login`  

Validates a user’s credentials and starts a session.  

#### Request Body
```json
{
  "email": "caleb@example.com",
  "password": "mypassword"
}
```

#### Success Response `200 OK`
```json
"Login successful. Session ID: 6F8D92A6E1F34C99A12B8E3F1F01D2A7"
```

#### Error Response `401 Unauthorized`
```json
"Invalid credentials"
```

---

### Get Session Info  
**GET** `/get-session`  

Retrieves the user ID stored in the current session.  

#### Success Response `200 OK`
```json
"User ID in session: 1"
```

#### Error Response `200 OK`
```json
"No user in session"
```

---

### Get Current User  
**GET** `/user/me`  

Returns the logged-in user’s ID from the session.  

#### Success Response `200 OK`
```json
"Logged in user ID: 1"
```

#### Error Response `401 Unauthorized`
```json
"No user logged in"
```

---

# Meals API

## Base URL
```
http://localhost:8081/meals
```

### List All Categories  
**GET** `/list_all_categories`  

Retrieves all meal categories available from **TheMealDB**.  

#### Example Request
```http
GET /meals/list_all_categories
```

#### Example Response `200 OK`
```json
{
  "meals": [
    { "strCategory": "Beef" },
    { "strCategory": "Chicken" },
    { "strCategory": "Dessert" }
  ]
}
```

---

### Get Meals by Category  
**GET** `/search_category?c={category}`  

Fetches meals belonging to a specific category.  

#### Example Request
```http
GET /meals/search_category?c=Seafood
```

#### Example Response `200 OK`
```json
{
  "meals": [
    {
      "strMeal": "Grilled Portuguese sardines",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/lpd4wy1614347943.jpg",
      "idMeal": "53041"
    },
    {
      "strMeal": "Salmon Prawn Risotto",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/xxrxux1503070723.jpg",
      "idMeal": "52823"
    }
  ]
}
```

---

### Search Meal by Name  
**GET** `/search?name={mealName}`  

Searches for a meal by its full or partial name.  

#### Example Request
```http
GET /meals/search?name=Arrabiata
```

#### Example Response `200 OK`
```json
{
  "meals": [
    {
      "idMeal": "52771",
      "strMeal": "Spicy Arrabiata Penne",
      "strInstructions": "Bring a large pot of water to a boil...",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
      "strCategory": "Vegetarian",
      "strArea": "Italian"
    }
  ]
}
```

---

### Filter Meals by Ingredient  
**GET** `/filter?ingredient={ingredient}`  

Returns meals containing a given main ingredient.  

#### Example Request
```http
GET /meals/filter?ingredient=chicken_breast
```

#### Example Response `200 OK`
```json
{
  "meals": [
    {
      "strMeal": "Chicken Handi",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/wyxwsp1486979827.jpg",
      "idMeal": "52795"
    },
    {
      "strMeal": "Tandoori chicken",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/qptpvt1487339892.jpg",
      "idMeal": "52806"
    }
  ]
}
```

---

### Lookup Meal by ID  
**GET** `/lookup?id={mealId}`  

Retrieves the full details of a meal by its unique ID.  

#### Example Request
```http
GET /meals/lookup?id=52772
```

#### Example Response `200 OK`
```json
{
  "meals": [
    {
      "idMeal": "52772",
      "strMeal": "Teriyaki Chicken Casserole",
      "strCategory": "Chicken",
      "strArea": "Japanese",
      "strInstructions": "Preheat oven to 350° F...",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg",
      "strYoutube": "https://www.youtube.com/watch?v=4aZr5hZXP_s"
    }
  ]
}
```

---

# Favorites API

## Base URL
```
http://localhost:8081/favorites
```

### Add to Favorites  
**POST** `/add`  

Adds a meal to a user’s list of favorite recipes.  

#### Request Parameters
| Name   | Type   | Required | Description       |
|--------|--------|----------|-------------------|
| userId | Long   | ✅        | ID of the user    |
| mealId | String | ✅        | TheMealDB meal ID |

#### Example Request
```http
POST /favorites/add?userId=1&mealId=52772
```

#### Success Response `200 OK`
```json
{
  "id": 10,
  "mealId": "52772",
  "user": {
    "userID": 1,
    "name": "John Doe",
    "email": "john@example.com"
  }
}
```

#### Error Codes
- `400 Bad Request` – Meal ID missing  
- `404 Not Found` – User not found  
- `409 Conflict` – Recipe already in favorites  

---

### Delete from Favorites  
**DELETE** `/delete`  

Removes a meal from a user’s list of favorite recipes.  

#### Request Parameters
| Name   | Type   | Required | Description       |
|--------|--------|----------|-------------------|
| userId | Long   | ✅        | ID of the user    |
| mealId | String | ✅        | TheMealDB meal ID |

#### Example Request
```http
DELETE /favorites/delete?userId=1&mealId=52772
```

#### Success Response `200 OK`
```json
{
  "id": 10,
  "mealId": "52772",
  "user": {
    "userID": 1,
    "name": "John Doe",
    "email": "john@example.com"
  }
}
```

#### Error Codes
- `404 Not Found` – Favorite recipe not found  

---

## Notes
- A user cannot add the same meal to favorites more than once.  
- Deleting a recipe removes it permanently from that user’s favorites.  
- Relies on the **Auth API** for user management and **Meals API** for meal data.  
