# MVVM + Retrofit2 + Kotlin + Recycler View

## Dependencies
### Retrofit
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
```
### Recycler View
```
implementation 'androidx.recyclerview:recyclerview:1.2.0-beta01'
```
### Glide (to load image)
```
implementation 'com.github.bumptech.glide:glide:4.12.0'
```
### Gson (to convert Json to Plain Old Java Object / POJO)
```
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```
### Lifecycle for ViewModel
```
implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
```

## API Source
[https://gist.githubusercontent.com/saniyusuf/406b843afdfb9c6a86e25753fe2761f4/raw/523c324c7fcc36efab8224f9ebb7556c09b69a14/Film.JSON](https://gist.githubusercontent.com/saniyusuf/406b843afdfb9c6a86e25753fe2761f4/raw/523c324c7fcc36efab8224f9ebb7556c09b69a14/Film.JSON)

## Files
### RetroInstance
A singleton for Retrofit. In Kotlin we have to use `data class`.
### APIService
Used to store all API calls, such as `@GET`, `@POST`, `@UPDATE`, etc
### MovieModel
This file is the `Plain Old Java Object (POJO)`
### MovieListAdapter
This file is needed for implementing `RecyclerView`

## Kotlin Specific
### Data Class
With `data class`, we don't have to specify `setter` and `getter` because it will automatically set it up for us.
For example: In `Java` we have something like this:
```
class Movie() {
    private String title;
    private String imageUrl;

    // create constructor
    public Movie(String title, String url) {
        this.title = title;
        this.url = url
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
```
In `Kotlin`, we can simply implement that with the following code:
```
data class Movie(val title: String, val imageUrl: String) { ... }
```

## Demo
<img src="https://user-images.githubusercontent.com/10084360/108469282-d0b41880-723c-11eb-92b6-cb39e348e8db.png" width="350px" height="650px" />
<img src="https://user-images.githubusercontent.com/10084360/108469293-d4e03600-723c-11eb-965d-247f474853cb.png" width="350px" height="650px" />
