# Build the Docker Image
docker build -t deypiyush8/docker-selenium-test .

# always use dockerUserName/ImageName --> so that is easy to push

# Run the Docker Image
docker run --rm deypiyush8/docker-selenium-test

<img width="504" height="213" alt="image" src="https://github.com/user-attachments/assets/1101c41d-86e9-4072-acc7-0ce9402d71f6" />

# push the image to docker hub 
docker push deypiyush8/docker-selenium-test

#after final push should be visiable in docker hub

<img width="963" height="310" alt="image" src="https://github.com/user-attachments/assets/f919fd79-e3ea-4fc9-a85e-c50ffa8b9079" />
