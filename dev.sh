#!/bin/bash

cd "$(dirname "$0")" || exit 1

echo "🛠️  Parando containers..."
docker-compose -f docker-compose.bd.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml down
echo "✅ Containers parados com sucesso!"

if [ "$1" = "back" ]; then
    echo "🔧 Iniciando backend..."
    docker-compose -f docker-compose.bd.yml -f docker-compose.backend.yml up --build -d
    
    elif [ "$1" = "front" ]; then
    echo "🎨 Iniciando frontend..."
    docker-compose -f docker-compose.bd.yml -f docker-compose.frontend.yml up --build -d
    
else
	echo "🚀 Iniciando backend e frontend..."
    docker-compose -f docker-compose.bd.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml up --build -d
    
fi

read -p "Pressione Enter para continuar..."