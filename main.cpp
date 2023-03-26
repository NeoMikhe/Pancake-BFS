#include <iostream>
#include <queue>
#include <set>
#include <string>
#include <algorithm>

void flip(char arr[], int i){
    char aux;
    int start = 0;
    while (start < i) {
        aux = arr[start];
        arr[start] = arr[i];
        arr[i] = aux;
        start++;
        i--;
    }
}

void printArray(char arr[], int n){
    for (int i = 0; i < n; ++i)
        std::cout << arr[i];
}

std::string bfs(std::string start, std::string end, int& count){
    std::queue<std::string> q;
    std::set<std::string> visited;
    q.push(start);
    visited.insert(start);

    while (!q.empty()){
        std::string curr = q.front();
        q.pop();
        count++;

        if (curr == end){
            return curr;
        }

        for (int i = 1; i < curr.size(); i++){
            std::string next = curr;
            flip(&next[0], i);
            if (visited.count(next) == 0){
                q.push(next);
                visited.insert(next);
            }
        }
    }

    return "";
}

int main(){
    std::string pancake = "abcdefghik";
    std::string pancakeEnd = pancake;
    random_shuffle(pancake.begin(), pancake.end());
    int count = 0;
    std::string result = bfs(pancake, pancakeEnd, count);
    std::cout << "Pancake: ";
    std::cout << pancake << std::endl;
    std::cout << std::endl;
    std::cout << "Pancake ordenado: ";
    std::cout << pancakeEnd << std::endl;
    std::cout << std::endl;
    if (result != ""){
        std::cout << "Pancake resuelto: " << result << std::endl;
    }
    else {
        std::cout << "No se encontro una solucion" << std::endl;
    }
    std::cout << "Nodos visitados: " << count << std::endl;
    return 0;
}
