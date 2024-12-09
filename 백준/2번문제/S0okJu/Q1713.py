def recommendation(n, s, candidates):
    pictures = dict()
    min_likes = float('inf')
    for i in range(s):
        if candidates[i] in pictures:
            candidates[i] += 1
            
        else:
            if len(pictures) < n:
                candidates[i] = 1
            # 만약에 사진이 꽉차있다면 변경하는 작업이 필요함
            else:
        
        min_likes = min(min_likes, candidates[i])    
                
         



n = int(input())
s = int(input())
candidates = list(map(int, input().split()))

recommendation(n,s, candidates)