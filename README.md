# MobileIA RecyclerView Libreria
La idea de esta libreria es facilmente agregar un RecyclerView en tu aplicación Android, con todas las funciones posibles.
## Como Usar
1. Agregar libreria desde Gradle
```gradle
implementation 'com.mobileia:recyclerview:0.0.12'
```
2. Agregar elemento en el XML de un Activity o Fragment:
```xml
<com.mobileia.recyclerview.MobileiaRecyclerView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="LinearLayoutManager"
        tools:listitem="@layout/item_contact" />
```
3. Obtenemos el elemento desde del Activity y lo configuramos igual que un RecyclerView normal:
```java
MobileiaRecyclerView recyclerView = findViewById(R.id.list);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(mAdapter);
```
4. Agregar vista cuando no hay elementos en el listado:
```java
recyclerView.setEmptyView(R.layout.partial_empty);
```