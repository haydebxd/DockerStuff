package com.docker.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	public static void main(String args[]) throws IOException {
		// create server socket on port number 9090
		ServerSocket serverSocket = new ServerSocket(9090);
		System.out.println("Server is currently running and waiting for client connection...");

		// Accept the incoming client connection
		Socket clientSocket = serverSocket.accept();
		System.out.println("Client connected!");

		// setup input and output streams for communication with the client
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		Scanner scan = new Scanner(System.in);
		
		// read message from the client
		String message = in.readLine();
		System.out.println("Client says: " + message);
		// send response to the client
		out.println("Message received by the server.");

		//close the sockets down
		clientSocket.close();
		serverSocket.close();
	}
}
