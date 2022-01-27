FROM node:16
WORKDIR /appnodejs
ADD . /appnodejs
RUN npm install
EXPOSE 3000
CMD npm start