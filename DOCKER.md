# Docker imagem pronta no dockerHub

## Criando uma imagen e push para dockerhub a partir do projeto.

1. **Deletar imagens antigas**
    ```bash
        docker rmi api-teste:0.1.9
    ``` 
2. **Build do projeto**
    ```bash
   docker build -t api-teste:0.1.9 -f docker/Dockerfile .   
   ``` 
3. **Tag do build**
   ```bash
        docker tag 272a379680ff lucasgalo/api-teste:0.1.9
   ```
4. **Login dockerhub**
   ```bash
        docker login
   ```
5. **Push da tag**
    ```bash
        docker push lucasgalo/api-teste:0.1.9
    ```
