FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:stable-alpine

#Conifgure nginx to not output info and notices to console
RUN sed -i 's|error_log  /var/log/nginx/error.log notice;|error_log  /var/log/nginx/error.log warn;|g' /etc/nginx/nginx.conf

#Configure nginx to not output success operations to console
RUN sed -i 's|access_log  /var/log/nginx/access.log  main;|access_log off;|g' /etc/nginx/nginx.conf

COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]